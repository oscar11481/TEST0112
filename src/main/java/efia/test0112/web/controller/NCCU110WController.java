package efia.test0112.web.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import efia.test0112.entity.Student;
import efia.test0112.service.NccuWeb3jService;
@Controller
@RequestMapping("/NCCU110W")
public class NCCU110WController {
	// ganache連線位址
	private final static String ganacheNode = "http://localhost:8545/";
	
	//保險公司EOA PRIVATE_KEY
	private final static String INSURANCECORP_PRIVATE_KEY = 
			"548d8f9f944db3be95657d38d98bf664963a8f97fa89844098299c56ed320eca";
	//醫院EOA PRIVATE_KEY
	private final static String HOSPITAL_PRIVATE_KEY = 
			"30264f99c3d0a5082a8a43698753adc6179a696bb5034ce16b22964ecde675de";
	//投保人EOA PRIVATE_KEY
	private final static String PATIENT_PRIVATE_KEY = 
			"";  
	//政府EOA PRIVATE_KEY
	private final static String GOVERNMENT_PRIVATE_KEY = 
			""; 
	//測試合約位址
	private final static String SIMPLESTORAGE_CONTRACT_ADDRESS = 
			"0x4d7E921f70dA4C6b573A11Cd2ECbd0d066988356";
	//醫療保險合約位址
	private final static String INSURANCE_CONTRACT_ADDRESS = 
			"0x407d3F38595A348ee0D5712950226990f77a4088";
	
	@Autowired
	private NccuWeb3jService nccuWeb3jService;
	
    @RequestMapping("/home")
    public String home() {
        return "NCCU/NCCU110W";
    }
    
	//醫療保險合約上鏈
	@RequestMapping("/deployInsuranceContract")
	public String deployInsuranceContract() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		String InsuranceContractAddress=  nccuWeb3jService.deployInsuranceContract(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY));
		String SimpleStorageContractAddress=  nccuWeb3jService.deploySimpleStorageContract(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY));
		System.out.println("醫療保險合約位址：" + InsuranceContractAddress);	
		System.out.println("測試用合約位址：" + SimpleStorageContractAddress);
		return "NCCU/NCCU110W";
	}
	
	@RequestMapping("/showValue")
	public String showValue() throws Exception {
		
//		System.out.println(nccuWeb3jService.showValue());
		
		return "NCCU/NCCU110W";
//		return "TEST0112F1/reqForm";
//		return "forward:/TEST0112F1/listEmployeeByQuery.do";
	}
	
	@RequestMapping("/checkReport")
	public String checkReport(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
    @RequestMapping("/addInsurance")
    public String addInsurance(HttpServletRequest request) throws Exception {
    	Web3j web3j = Web3j.build(new HttpService(ganacheNode));
    	Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
//        Integer age = Integer.parseInt(request.getParameter("age"));
        String rdoMode = request.getParameter("rdoMode");
        String privateKey_from_http = request.getParameter("privateKey");
        Credentials credentials_from_http = nccuWeb3jService.getCredentialsFromPrivateKey(privateKey_from_http);
        //確認有無重複投保
        if(nccuWeb3jService.checkInsuranceContract(web3j, 
        		credentials, credentials_from_http.getAddress())==true){
        	return "forward:/NCCU110W/errorReport.do?message=" + "撥款/扣款帳戶重複，請確認是否重複投保";
        }
        //投保人付保費
        nccuWeb3jService.transferETH(web3j, credentials_from_http, credentials.getAddress(), "1");
        //投保
        nccuWeb3jService.Insured(web3j, 
        		credentials, 
        		credentials_from_http.getAddress(), 
        		name, 
        		address);
        return "forward:/NCCU110W/infoReport.do?message=" + "本保險公司已受理您的投保，投保類型為：防疫​保單";
    }
	
    @RequestMapping("/errorReport")
    public ModelAndView errorReport(@RequestParam("message") String message, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("message", message);
        mav.setViewName("common/errorReport");
        return mav;
    }
    
    @RequestMapping("/infoReport")
    public ModelAndView infoReport(@RequestParam("message") String message, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("message", message);
        mav.setViewName("common/infoReport");
        return mav;
    }
    
}
