package packg1;

class GCScope {
	GCScope t;
	int i;

	GCScope(int k) {
		i = k;
	}

	public static void main(String args[]) {
		GCScope t1 = new GCScope(1);
		GCScope t2 = new GCScope(2);
		GCScope t3 = new GCScope(3);

		// No Object Is Eligible for GC
		System.out.println(t1+"  "+t2+" "+t3);
		t1.t = t2; // No Object Is Eligible for GC
		t2.t = t3; // No Object Is Eligible for GC
		t3.t = t1; // No Object Is Eligible for GC

		t1 = null;
		// No Object Is Eligible for GC (t3.t still has a reference to t1)
		
		t2 = null;
		// No Object Is Eligible for GC (t3.t.t still has a reference to t2)
		System.out.println("t1 = "+t3.t);
		System.out.println("t2 = "+t3.t.t);
		t3 = null;
		// All the 3 Object Is Eligible for GC (None of them have a reference.
		// only the variable t of the objects are referring each other in a
		// rounded fashion forming the Island of objects with out any external
		// reference)
		System.gc();
	}

	@Override
	protected void finalize() {
		System.out.println("Garbage collected from object" + i);
		
	}
}
