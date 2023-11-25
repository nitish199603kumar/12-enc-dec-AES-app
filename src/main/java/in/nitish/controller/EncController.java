package in.nitish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nitish.service.EncService;

@RestController
public class EncController {

	@Autowired
	private EncService encService;

	@GetMapping("/enc")
	public String encryptData(@RequestParam String encData) {
		
		System.out.println("data for encryption " +encData);
		String encrypt = encService.encrypt(encData);

		System.out.println("encrypted data " +encrypt);
		return encrypt;

	}

	@GetMapping("/dec")
	public String decryptData(@RequestParam String decData) {

		System.out.println("data for decryption " +decData);
		String decrypt = encService.decrypt(decData);
		System.out.println("decrypted data " +decrypt);
		return decrypt;

	}
}
