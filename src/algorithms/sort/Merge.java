package algorithms.sort;

/**
 * @ClassName: Merge 
 * @Description: �鲢����
 *
 * @author Goffery Gong
 * @date 2018��9��20�� ����4:47:49
 */
public class Merge {
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	//�ݹ����sort
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);		//����������
		sort(a, mid + 1, hi);	//���Ұ������
		merge(a, lo, mid, hi);	//�鲢���
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		Comparable[] aux = new Comparable[a.length];

		//���Ƚ����鿽��һ�ݵ�aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		//�ж�aux�е�Ԫ�ش�С���鲢��a[]��
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		Integer[] a = { 2, 5, 8, 3, 6, 9 };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
}