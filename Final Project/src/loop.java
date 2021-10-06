import static org.junit.Assert.*;

import org.junit.Test;

public class loop {

	@Test
	public void test() {
		String koko = "//*[@id=\\\"answers\\\"]/div[AA]/div[BB]/input";
		String[][] ar = {
                {"1", "2", "a"}, 
                {"2", "2", "b"},
                {"3", "2", "c"},
                {"4", "2", "d"}
              };
		
		for (int i = 0; i < ar.length; i++) {
			koko = koko.replace("AA", ar[i][1]);
			koko = koko.replace("BB", ar[i][2]);	
            //x = ar[i];
            //System.out.print(x + " ");
			System.out.print(koko);
		}
			
	}

}
