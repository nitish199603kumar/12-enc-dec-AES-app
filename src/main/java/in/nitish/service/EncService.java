package in.nitish.service;

//encryption decryption using secret key cipher
public interface EncService {

	public String encrypt(String data);
	public String decrypt(String data);
}
