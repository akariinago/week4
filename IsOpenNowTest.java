import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class IsOpenNowTest {
  @Test
  public void testIsOpenNow() {
    assertFalse(IsOpenNow.isOpenNow(Calendar.SUNDAY, 16));
    assertTrue(IsOpenNow.isOpenNow(Calendar.TUESDAY, 16));
    assertFalse(IsOpenNow.isOpenNow(Calendar.SATURDAY, 16));
    assertTrue(IsOpenNow.isOpenNow(Calendar.THURSDAY, 1));
    //...
  }
}
