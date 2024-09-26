import java.util.ArrayList;
import java.util.List;

public class ExchangeObjectsDivision {
	
	public static void main(String[] args) {
		List<ModelClass> models = new ArrayList<>();
		for(int i=1;i<+15;i++)
		{
		 ModelClass model = new ModelClass(i,"Name"+i);
		 models.add(model);
		}
		List<List<ModelClass>> chunks = splitList(models, 3);
		for(List<ModelClass> chunk:chunks)
			System.out.println(chunk);
	}
	
	public static <T> List<List<T>> splitList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

}
