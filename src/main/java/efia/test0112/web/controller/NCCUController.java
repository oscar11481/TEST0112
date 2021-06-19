package efia.test0112.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import efia.test0112.service.NccuWeb3jService;
@Controller
@RequestMapping("/TEST0112F3")
public class NCCUController {
	private NccuWeb3jService nccuWeb3jService;
	@RequestMapping("/showValue")
	public String startProcess() throws Exception {
		nccuWeb3jService.showValue();
		return "TEST0112F1/deploy";
	}
}
