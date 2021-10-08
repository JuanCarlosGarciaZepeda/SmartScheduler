package uam.azc.adsi.smartscheduler.classes;

public class N {
    private String ln;// apellido
    private String n;// nombre
    private String nk;// apodo
    private String t;// titulo

    // constructor 
    public N(){}

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getNk() {
        return nk;
    }

    public void setNk(String nk) {
        this.nk = nk;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
    
    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ln == null) ? 0 : ln.hashCode());
        result = prime * result + ((n == null) ? 0 : n.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        N other = (N) obj;
        if (ln == null) {
            if (other.ln != null)
                return false;
        } else if (!ln.equals(other.ln))
            return false;
        if (n == null) {
            if (other.n != null)
                return false;
        } else if (!n.equals(other.n))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "N [ln=" + ln + ", n=" + n + ", nk=" + nk + ", t=" + t + "]";
    }
}
