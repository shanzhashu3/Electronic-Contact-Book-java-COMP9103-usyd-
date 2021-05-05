
public class Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=4) {
			System.out.print("error");
		}
		PersonProcesser pp = new PersonProcesser(args);
		pp.readInputFile();
		pp.readInstruction();
	}

}
