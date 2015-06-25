import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {
	
	@Test
	public void test() {
		assertEquals(450.0, Matrix.main(3), 0);
		assertEquals(3680.0, Matrix.main(4), 0);
		assertEquals(18250.0, Matrix.main(5), 0);
		
	}

}
