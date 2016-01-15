import java.util.Random;
import java.io.*;

public class CreateRandoms {

	public static String[] createRandSkillsArr() {
		String[] skills = new String[19];
		Random rand = new Random();
		int i = 1;
		int curMax = 19;
		while (i < 20) {
			int randIndex = rand.nextInt(curMax);
			while (skills[randIndex] != null) {
				randIndex = rand.nextInt(curMax);
			}
			if (randIndex == curMax) {
				curMax--;
			}
			skills[randIndex] = Integer.toString(i);
			i++;
		}
		return skills;
	}

	public static String[] createRandCulArr() {
		String[] cult = new String[21];
		Random rand = new Random();
		int i = 1;
		int curMax = 21;
		while (i < 22) {
			int randIndex = rand.nextInt(curMax);
			while (cult[randIndex] != null) {
				randIndex = rand.nextInt(curMax);
			}
			if (randIndex == curMax) {
				curMax--;
			}
			cult[randIndex] = Integer.toString(i);
			i++;
		}
		return cult;
	}

	public static void main(String[] args) {
		String s = new String();
		try {
			BufferedWriter out = new BufferedWriter(
					new FileWriter("random skill arrays.txt"));
			out.write("Skill Lists:" + "\n");
			out.newLine();

			for (int i = 0; i < 1000; i++) {
				String[] arr = createRandSkillsArr();
				int len = arr.length;
				s = ("\"skills\": [");
				for (int j = 0; j < len; j++) {
					if (j == 0)
						s += ("'" + arr[j] + "'");
					else
						s += (", '" + arr[j] + "'");
				}
				s += ("]\n");
				out.write(s + "\n");
				out.newLine();
			}
			
			BufferedWriter out2 = new BufferedWriter(
					new FileWriter("random culture arrays.txt"));

			out2.write("\n\nCulture Lists:" + "\n");
			out2.newLine();

			for (int i = 0; i < 1000; i++) {
				String[] arr = createRandCulArr();
				int len = arr.length;
				s = ("\"culture\": [");
				for (int j = 0; j < len; j++) {
					if (j == 0)
						s += ("'" + arr[j] + "'");
					else
						s += (", '" + arr[j] + "'");
				}
				s += ("]\n");
				out2.write(s + "\n");
				out2.newLine();
			}
			out.close();
			out2.close();
		} catch (IOException e) {
		}
		

	}
}
