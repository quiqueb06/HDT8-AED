import org.junit.Test;
import static org.junit.Assert.*;

public class VectorHeapTest {

    @Test
    public void testAddAndSize() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertEquals("El tamaño inicial debe ser 0", 0, heap.size());
        
        heap.add(10);
        assertEquals("El tamaño debe ser 1 tras agregar un elemento", 1, heap.size());
        
        heap.add(5);
        assertEquals("El tamaño debe ser 2 tras agregar otro elemento", 2, heap.size());
    }

    @Test
    public void testGetFirst() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(5);
        heap.add(15);
        
        assertEquals("getFirst debe devolver el elemento más pequeño", Integer.valueOf(5), heap.getFirst());
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(5);
        heap.add(15);
        heap.add(1);

        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertEquals(Integer.valueOf(15), heap.remove());
        assertTrue("La cola debe estar vacía tras remover todo", heap.isEmpty());
    }

    @Test
    public void testClear() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(5);
        heap.clear();
        
        assertTrue("isEmpty debe ser true luego de un clear", heap.isEmpty());
        assertEquals("El tamaño debe ser 0 luego de un clear", 0, heap.size());
    }

    @Test
    public void testEmptyHeap() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertNull("getFirst debe devolver null si está vacío", heap.getFirst());
        assertNull("remove debe devolver null si está vacío", heap.remove());
    }
}