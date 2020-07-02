import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDriver {
	List<Block> blockchain = new ArrayList<Block>();
	public static void main(String[] args) throws NoSuchAlgorithmException {		
		Scanner scanner = new Scanner(System.in);	
		System.out.println("블록체인 기반 회원가입을 시작합니다.");
		
		System.out.print("아이디를 입력하세요 : ");
		String name = scanner.nextLine();
		String[] idTransactions = {name};
		Block idBlock = new Block(new BlockHeader(null, idTransactions), idTransactions);
		
		System.out.print("비밀번호를 입력하세요 : ");
		String password = scanner.nextLine();
		String[] passwordTransactions = {password};
		Block passwordBlock = new Block(new BlockHeader(idBlock.getBlockHash().getBytes(), passwordTransactions), passwordTransactions);
		
		System.out.print("취미를 입력하세요 : ");
		String hobby = scanner.nextLine();
		String[] hobbyTrasactions = {hobby};
		Block hobbyBlock = new Block (new BlockHeader(passwordBlock.getBlockHash().getBytes(), hobbyTrasactions), hobbyTrasactions);
		
		System.out.println("생성된 아이디 Hash값 : " + idBlock.getBlockHash());
		System.out.println("생성된 비밀번호 Hash값 : " + passwordBlock.getBlockHash());
		System.out.println("생성된 취미 Hash값 : " + hobbyBlock.getBlockHash());
	}
}
