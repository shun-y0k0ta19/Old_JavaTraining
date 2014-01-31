package ex03_05;

public class MethodBenchmark extends Benchmark {

	private int loopcount;
	
	public void SetLoopcount(int loopcount){
		this.loopcount = loopcount;
	}
	
	public int GetLoopcount(){
		return this.loopcount;
	}
	
	@Override
	void benchmark(){
		for(int i = 0; i < this.loopcount; i++ );
	}
	

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		MethodBenchmark loop = new MethodBenchmark();
		loop.SetLoopcount(Integer.parseInt(args[1]));
		long time = loop.repeat(count);
		System.out.println(loop.GetLoopcount() + "loops " + count + 
				"methods in " +time + "nanoseconds");
	}

}
