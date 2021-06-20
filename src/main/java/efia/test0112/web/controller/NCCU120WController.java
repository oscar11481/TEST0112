package efia.test0112.web.controller;

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
@RequestMapping("/NCCU120W")
public class NCCU120WController {
	// ganache連線位址
	private final static String ganacheNode = "http://localhost:7545/";
	
	//保險公司EOA PRIVATE_KEY
	private final static String INSURANCECORP_PRIVATE_KEY = 
			"40a763b2512bceff7ca50b506a4ca3b308b091c114044c3e5946bf1da16c5517";
	//醫院EOA PRIVATE_KEY
	private final static String HOSPITAL_PRIVATE_KEY = 
			"";
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
			"0x529f0C9D137132666f46586d5A672094Dd7B00a9";
	
	@Autowired
	private NccuWeb3jService nccuWeb3jService;
	
    @RequestMapping("/home")
    public String home() {
        return "NCCU/NCCU120W";
    }
    
	//醫療保險合約上鏈
	@RequestMapping("/deployInsuranceContract")
	public String deployInsuranceContract(HttpServletRequest request) throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		String InsuranceContractAddress=  nccuWeb3jService.deployInsuranceContract(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY));
		return "forward:/NCCU120W/infoReport.do?message=" + "已部署智能合約，合約位址為："+ InsuranceContractAddress;
	}
	
    @RequestMapping("/infoReport")
    public ModelAndView infoReport(@RequestParam("message") String message, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("message", message);
        mav.setViewName("common/infoReport");
        return mav;
    }
    
}
