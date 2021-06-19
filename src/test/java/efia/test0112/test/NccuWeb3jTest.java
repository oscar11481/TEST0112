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
import nccu.blockchain.Web3jTest.SimpleStorage;

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

    @Autowired
    private NccuWeb3jService nccuWeb3jService;
    //顯示版本
	@Test
	public void test_printWeb3Version() {
		Web3j web3j = Web3j.build(new HttpService("http://localhost:7545/"));
		nccuWeb3jService.printWeb3Version(web3j);
	}
	//部署合約
	@Test
	public void test_deployContract() throws Exception {
		String private_key = "371d0d643bc2178d51aab1e9ab577dddc083eae06bf546d1570116bf03e93806";
		Web3j web3j = Web3j.build(new HttpService("http://localhost:7545/"));
//		String ContractAddress=  nccuWeb3jService.deploySimpleStorageContract(web3j, 
//				nccuWeb3jService.getCredentialsFromPrivateKey(private_key));
		String ContractAddress=  nccuWeb3jService.deployInsuranceContract(web3j, 
				nccuWeb3jService.getCredentialsFromPrivateKey(private_key));
		System.out.println(ContractAddress);
	}
	//載入合約，讀取值，寫入值
	@Test
	public void test_loadContract() throws Exception {		
		String contractAddress="0x36897478B8bE4924384332cd522d399A9Ae5d816";
		Web3j web3j = Web3j.build(new HttpService("http://localhost:7545/"));
		String private_key = "371d0d643bc2178d51aab1e9ab577dddc083eae06bf546d1570116bf03e93806";
		Credentials credentials = nccuWeb3jService.getCredentialsFromPrivateKey(private_key);		
		SimpleStorage simpleStorage = nccuWeb3jService.loadContract
				(contractAddress, web3j, credentials);
		BigInteger currentValue;
		currentValue = simpleStorage.get().send();
		System.out.println(currentValue.toString());
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
}
