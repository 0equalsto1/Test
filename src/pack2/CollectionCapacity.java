package pack2;
import java.lang.reflect.Field;
import java.util.ArrayList;
public class CollectionCapacity  {

    @SuppressWarnings("boxing")
				public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(3);
        for (int i = 0; i < 17; i++) {
            list.add(i);
            System.out.format("Size: %2d, Capacity: %2d%n",
                              list.size(), getCapacity(list));
        }
    }

    static int getCapacity(ArrayList<?> list) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(list)).length;
    }
}