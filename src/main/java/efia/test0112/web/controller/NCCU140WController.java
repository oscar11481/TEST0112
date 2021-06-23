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
@RequestMapping("/NCCU140W")
public class NCCU140WController {
	// ganache連線位址
	private final static String ganacheNode = "http://localhost:8545/";
	
	//保險公司EOA PRIVATE_KEY
	private final static String INSURANCECORP_PRIVATE_KEY = 
			"548d8f9f944db3be95657d38d98bf664963a8f97fa89844098299c56ed320eca";
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
			"0x407d3F38595A348ee0D5712950226990f77a4088";
	
	@Autowired
	private NccuWeb3jService nccuWeb3jService;
	
    @RequestMapping("/home")
    public String home() {
        return "NCCU/NCCU140W";
    }
    
    @RequestMapping("/insRecord")
    public String insRecord(HttpServletRequest request) throws Exception {
    	Web3j web3j = Web3j.build(new HttpService(ganacheNode));
    	Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);
        String PATIENT_EOA = request.getParameter("EOA");
        String symptom = request.getParameter("symptom");
        String cause = request.getParameter("cause");
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer money = 10; //ETHER        
        String privateKey_from_http = request.getParameter("privateKey");
        Credentials credentials_from_http = nccuWeb3jService.getCredentialsFromPrivateKey(privateKey_from_http);
        String HospitalEOA = nccuWeb3jService.getHospitalEOA(web3j, credentials).toLowerCase();
        if(credentials_from_http.getAddress().toLowerCase().equals(HospitalEOA)==false){
        	return "forward:/NCCU140W/errorReport.do?message=" + "此功能限制醫療院所才能使用，請確認帳戶是否正確";
        }        
        nccuWeb3jService.insRecord(web3j, credentials, PATIENT_EOA, symptom, cause, day, money);
        return "forward:/NCCU140W/infoReport.do?message=" + "已新增病歷";
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
