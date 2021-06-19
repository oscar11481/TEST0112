package efia.test0112.test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import efia.test0112.service.NccuWeb3jService;
import nccu.blockchain.Contract.InsuranceContract;
import nccu.blockchain.Contract.SimpleStorage;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.JAXBException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NccuWeb3jTest {

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
    //顯示版本
	@Test
	public void test_printWeb3Version() {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		nccuWeb3jService.printWeb3Version(web3j);
	}
	//部署合約
	@Test
	public void test_deployContract() throws Exception {
		String private_key = INSURANCECORP_PRIVATE_KEY;
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
//		String ContractAddress=  nccuWeb3jService.deploySimpleStorageContract(web3j, 
//				nccuWeb3jService.getCredentialsFromPrivateKey(private_key));
		String ContractAddress=  nccuWeb3jService.deployInsuranceContract(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(private_key));
		System.out.println(ContractAddress);
	}
	//呼叫合約函式和值
	@Test
	public void test_CallContractObject() throws Exception {		
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);		
		SimpleStorage simpleStorage = nccuWeb3jService.loadSimpleStorageContract
				(SIMPLESTORAGE_CONTRACT_ADDRESS, web3j, credentials);
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
	
	//輸入數值
	@Test
	public void test_transferETH() throws Exception {
		BigInteger money = BigInteger.ZERO; // 住院金額
		money = new BigInteger("36000"); //MILLIETHER = 0.001 ETHER
		String payMoney = "" + (money.longValueExact()/1000); //ETHER
		System.out.println("住院金額:" + money.longValueExact());
		// 撥款理賠金
//		String payMoney = "" + (money.longValueExact()/1000);
//		transferETH(insuranceCorp, address, insuranceCorpKey, payMoney);
	}

	
}
