package efia.test0112.test;

import java.math.BigInteger;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import efia.test0112.service.NccuWeb3jService;
import nccu.blockchain.Contract.InsuranceContract;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NccuWeb3jTest {

	// ganache連線位址
	private final static String ganacheNode = "http://localhost:8545/";
	
	//保險公司EOA PRIVATE_KEY
	private final static String INSURANCECORP_PRIVATE_KEY = 
			"548d8f9f944db3be95657d38d98bf664963a8f97fa89844098299c56ed320eca";
	//醫院EOA PRIVATE_KEY
	private final static String HOSPITAL_PRIVATE_KEY = 
			"0289f277d9fa455806f3be6065b8d3db20575a111560e1c6f04418c0e304a1f5";
	//投保人EOA PRIVATE_KEY
	private final static String PATIENT_PRIVATE_KEY = 
			"bbb99c7ee94f17c5dd240ec219beb7212d5e73753daa48962e079830619505e4";  
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
    //顯示版本
	@Test
	public void test_printWeb3Version() {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		nccuWeb3jService.printWeb3Version(web3j);
	}
	//部署合約
	@Test
	public void test_deployContract() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
//		nccuWeb3jService.deploySimpleStorageContract(web3j, nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY));
		nccuWeb3jService.deployInsuranceContract(web3j, nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY));
	}
	//呼叫合約函式和值
	@Test
	public void test_CallContract() throws Exception {		
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);		
		System.out.println(credentials.getAddress());
//		SimpleStorage simpleStorage = nccuWeb3jService.loadSimpleStorageContract
//				(SIMPLESTORAGE_CONTRACT_ADDRESS, web3j, credentials);
		InsuranceContract insuranceContract = nccuWeb3jService.loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);
	}
	//顯示數值
	@Test
	public void test_showValue() throws Exception {
		System.out.println(nccuWeb3jService.showValue());
	}
	//輸入數值
	@Test
	public void test_insertValue() throws Exception {
		BigInteger count = new BigInteger("3");
		nccuWeb3jService.InsertValue(count);
		System.out.println(nccuWeb3jService.showValue());
	}	
	//測試交易
	@Test
	public void test_transferETH() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		BigInteger money = BigInteger.ZERO; // 住院金額
		money = new BigInteger("36000"); //MILLIETHER = 0.001 ETHER
		String payMoney = "" + (money.longValueExact()/1000); //ETHER
		System.out.println("住院金額:" + money.longValueExact());
		// 撥款理賠金
		nccuWeb3jService.transferETH(web3j, 
		nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY),  
		nccuWeb3jService.getCredentialsFromPrivateKey(PATIENT_PRIVATE_KEY).getAddress(), 
		payMoney);
		//PATIENT_PRIVATE_KEY
		//INSURANCECORP_PRIVATE_KEY
	}
	//測試投保
	@Test
	public void test_Insured() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			
		String PATIENT_EOA = nccuWeb3jService.getCredentialsFromPrivateKey(PATIENT_PRIVATE_KEY).getAddress();
		String name="test";
		String address="taipei";
		System.out.println(PATIENT_EOA);
		nccuWeb3jService.Insured(web3j, credentials, PATIENT_EOA, name, address);
	}
	//測試投保人是否投保成功
	@Test
	public void test_checkPATIENT_EXIST() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			
		String PATIENT_EOA = nccuWeb3jService.getCredentialsFromPrivateKey(PATIENT_PRIVATE_KEY).getAddress();
		System.out.println(PATIENT_EOA);
		System.out.println(nccuWeb3jService.checkInsuranceContract(web3j, credentials, PATIENT_EOA));
	}
	//測試監聽區塊鏈智能合約事件
	@Test
	public void test_Oracle() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			
		nccuWeb3jService.startOracle(web3j, credentials, INSURANCE_CONTRACT_ADDRESS);
	}
	//測試增加病歷
	@Test
	public void test_insRecord() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			
		String PATIENT_EOA = nccuWeb3jService.getCredentialsFromPrivateKey(PATIENT_PRIVATE_KEY).getAddress();
		String symptom = "進入隔離病房治療";
		String cause = "接觸到確診病患";
		Integer day = 6;
		Integer money = 10;
		nccuWeb3jService.insRecord(web3j, credentials, PATIENT_EOA, symptom, cause, day, money);
	}
	//測試增加醫院EOA
	@Test
	public void test_setHospitalEOA() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			
		String HOSPITAL_EOA = nccuWeb3jService.getCredentialsFromPrivateKey(HOSPITAL_PRIVATE_KEY).getAddress();
		nccuWeb3jService.setHospitalEOA(web3j, credentials, HOSPITAL_EOA);
	}
	//測試讀取醫院EOA
	@Test
	public void test_getHospitalEOA() throws Exception {        
//	       String str = "abcd++ef";
//	       System.out.println(str.toUpperCase());
//	       System.out.println(str.toLowerCase());
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));	
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);			

		String HospitalEOA = nccuWeb3jService.getHospitalEOA(web3j, credentials).toLowerCase();
		System.out.println(HospitalEOA);
		
        Credentials credentials_from_http = nccuWeb3jService.getCredentialsFromPrivateKey(HOSPITAL_PRIVATE_KEY); 
        System.out.println(credentials_from_http.getAddress().toLowerCase());
        
        if(credentials_from_http.getAddress().toLowerCase().equals(HospitalEOA)==true){
        	System.out.println("ok");
        } 
        
	}
	//測試讀取醫院EOA
	@Test
	public void test_multiply() throws Exception {   
		BigInteger days = new BigInteger("4");
		BigInteger money = new BigInteger("3");	
		BigInteger test =days.multiply(money);
		System.out.println(test.toString());
	}
	//測試IPFS讀取
	@Test
	public void test_ipfs() throws Exception {   

	}
}
