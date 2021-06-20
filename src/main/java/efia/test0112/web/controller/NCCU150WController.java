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
@RequestMapping("/NCCU150W")
public class NCCU150WController {
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
        return "NCCU/NCCU150W";
    }
    
	//醫療保險合約上鏈
	@RequestMapping("/setHospitalEOA")
	public String setHospitalEOA(HttpServletRequest request) throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		String HOSPITAL_EOA = request.getParameter("EOA");
		nccuWeb3jService.setHospitalEOA(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY), 
				HOSPITAL_EOA);
		return "forward:/NCCU150W/infoReport.do?message=" + "已設置帳戶" + HOSPITAL_EOA + "完成";
	}
	
    @RequestMapping("/infoReport")
    public ModelAndView infoReport(@RequestParam("message") String message, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("message", message);
        mav.setViewName("common/infoReport");
        return mav;
    }
    
}
