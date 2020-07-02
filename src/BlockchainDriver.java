import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//코드 참고 => https://www.popit.kr/java-%EC%BD%94%EB%93%9C%EB%A1%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-%EB%B8%94%EB%A1%9D%EC%B2%B4%EC%9D%B8blockchain/

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
