public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int total = m + n;
        if(total%2 != 0)
            return find_kth(A,m,B,n,total/2 + 1);
        else
            return (find_kth(A,m,B,n,total/2) + find_kth(A,m,B,n,total/2+1))/2;
    }
    private double find_kth(int A[], int m, int B[], int n, int k) {
        if(m > n) return find_kth(B,n,A,m,k);
        if(m == 0) return B[k-1];
        if(k == 1) return Math.min(A[0], B[0]);

        int ia = Math.min(k/2, m), ib = k - ia;
        if(A[ia-1] < B[ib-1])
          return find_kth(Arrays.copyOfRange(A,ia,m),m-ia,B,n,k-ia);
        else if(A[ia-1] > B[ib-1])
          return find_kth(A,m,Arrays.copyOfRange(B,ib,n),n-ib,k-ib);
        else
          return A[ia-1];
    }
}
