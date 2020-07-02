import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDriver {
	List<Block> blockchain = new ArrayList<Block>();
	public static void main(String[] args) throws NoSuchAlgorithmException {		
		Scanner scanner = new Scanner(System.in);	
		System.out.println("���ü�� ��� ȸ�������� �����մϴ�.");
		
		System.out.print("���̵� �Է��ϼ��� : ");
		String name = scanner.nextLine();
		String[] idTransactions = {name};
		Block idBlock = new Block(new BlockHeader(null, idTransactions), idTransactions);
		
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		String password = scanner.nextLine();
		String[] passwordTransactions = {password};
		Block passwordBlock = new Block(new BlockHeader(idBlock.getBlockHash().getBytes(), passwordTransactions), passwordTransactions);
		
		System.out.print("��̸� �Է��ϼ��� : ");
		String hobby = scanner.nextLine();
		String[] hobbyTrasactions = {hobby};
		Block hobbyBlock = new Block (new BlockHeader(passwordBlock.getBlockHash().getBytes(), hobbyTrasactions), hobbyTrasactions);
		
		System.out.println("������ ���̵� Hash�� : " + idBlock.getBlockHash());
		System.out.println("������ ��й�ȣ Hash�� : " + passwordBlock.getBlockHash());
		System.out.println("������ ��� Hash�� : " + hobbyBlock.getBlockHash());
	}
}
