package testNgExample;

import org.testng.annotations.Test;

public class Priorityexample {
	
	@Test(priority=-100)
	public void NegativePrioirty100()
	{
		System.out.println("Negative Prioirty-100");
	}
	@Test(priority=-2)
	public void NegativeonePrioirty()
	{
		System.out.println("Negative Prioirty-2");
	}
	@Test(priority=-1)
	public void NegativePrioirty()
	{
		System.out.println("Negative Prioirty-1");
	}
	@Test(priority=-1)
	public void AbNegativePrioirty()
	{
		System.out.println("Negative Prioirty-1 ab");
	}
	
	// We can pass priority as default value zero. 
	@Test(priority=0)
	public void ZerothPriority()
	{
		System.out.println("Zeroth Priority");
	}
	@Test(priority=1)
	public void PositivePriority()
	{
		System.out.println("Positive Priority");
	}
	// It is not mandatory to pass priority in a order
	@Test(priority=100)
	public void SkippedPriority()
	{
		System.out.println("Skipped Priority");
	}
	


}
