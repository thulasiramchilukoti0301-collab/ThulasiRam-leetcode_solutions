class Solution {
    static final long MOD = 1_000_000_007;
    int m;
    public int zigZagArrays(int n, int l, int r) {
        m = r - l + 1;
        long[][] P = new long[m][m];
        long[][] Q = new long[m][m];
        for(int v = 0; v < m; v++){
            for(int u = 0; u < m; u++){
                if(u < v) P[v][u] = 1;
                if(u > v) Q[v][u] = 1;
            }
        }
        long[] A2 = new long[m];
        long[] B2 = new long[m];
        for(int v = 0; v < m; v++){
            A2[v] = v;
            B2[v] = m - 1 - v;
        }
        long k = (long) n - 2;
        long j = k / 2;
        long rem = k % 2;

        long[][] PQ = multiply(P,Q);
        long[][] QP = multiply(Q,P);

        long[][] PQj = power(PQ,j);
        long[][] QPj = power(QP,j);
            
        long[] An,Bn;
        if(rem == 0){
            An = multiplyVec(PQj,A2);
            Bn = multiplyVec(QPj, B2);
        } else {
            An = multiplyVec(P,multiplyVec(QPj,B2));
            Bn = multiplyVec(Q,multiplyVec(PQj,A2));
        }
        long sum = 0;
        for(long x : An) sum = (sum + x) % MOD;
        for(long x : Bn) sum = (sum + x) % MOD;
        return (int)sum;
        
    }

    long[][] multiply(long[][] X, long[][] Y){
        int n = X.length;
        long[][] Z = new long[n][n];
        for(int i = 0; i < n; i++){
            for(int kk = 0; kk < n; kk++){
                if(X[i][kk] == 0) continue;
                long a = X[i][kk];
                long[] yk = Y[kk];
                long[] zi = Z[i];
                for(int jj = 0; jj < n; jj++){
                    if(yk[jj] != 0){
                        zi[jj] = (zi[jj] + a*yk[jj]) % MOD;
                    }
                }
            }
        }
        return Z;
    }

    long[] multiplyVec(long[][] X, long[] v) {
        int n = X.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long s = 0;
            long[] xi = X[i];
            for (int j = 0; j < n; j++) {
                if (xi[j] != 0) s = (s + xi[j] * v[j]) % MOD;
            }
            res[i] = s;
        }
        return res;
    }

    long[][] power(long[][] M, long exp) {
        int n = M.length;
        long[][] result = identity(n);
        long[][] base = M;
        while (exp > 0) {
            if ((exp & 1) == 1) result = multiply(result, base);
            base = multiply(base, base);
            exp >>= 1;
        }
        return result;
    }

    long[][] identity(int n) {
        long[][] I = new long[n][n];
        for (int i = 0; i < n; i++) I[i][i] = 1;
        return I;
    }
}