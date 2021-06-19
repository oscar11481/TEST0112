package efia.test0112.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import efia.test0112.service.NccuWeb3jService;
@Controller
@RequestMapping("/NCCU110W")
public class NCCU110WController {
	// ganache連線位址
	private final static String ganacheNode = "http://localhost:7545/";
	
	//保險公司EOA PRIVATE_KEY
	private final static String INSURANCECORP_PRIVATE_KEY = 
			"ef7d86a0ef5b20bf93bd44b209519b4945418710a4e917334fb37fb33b73371c";
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
			"0x4d7E921f70dA4C6b573A11Cd2ECbd0d066988356";
	
	@Autowired
	private NccuWeb3jService nccuWeb3jService;
	
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
		
		System.out.println(nccuWeb3jService.showValue());
		
		return "NCCU/NCCU110W";
//		return "TEST0112F1/reqForm";
//		return "forward:/TEST0112F1/listEmployeeByQuery.do";
	}
	
}
