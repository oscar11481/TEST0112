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
@RequestMapping("/NCCU130W")
public class NCCU130WController {
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
        return "NCCU/NCCU130W";
    }
    
	//醫療保險合約上鏈
	@RequestMapping("/startOracle")
	public String startOracle(HttpServletRequest request) throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		String HOSPITAL_EOA = request.getParameter("EOA");
		nccuWeb3jService.startOracle(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY),
				INSURANCE_CONTRACT_ADDRESS);
		return "forward:/NCCU130W/infoReport.do?message=" + "監聽區塊鏈智能合約事件中...";
	}
	
    @RequestMapping("/infoReport")
    public ModelAndView infoReport(@RequestParam("message") String message, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); 
        mav.addObject("message", message);
        mav.setViewName("common/infoReport");
        return mav;
    }
    
}
