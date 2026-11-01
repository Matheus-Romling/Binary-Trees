class No {
    public int valor;
    public No esq;
    public No dir;
    
    public No(int valor, No esq, No dir){
        this.valor = valor;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {

    private No raiz;
    public Arvore(){
        this.raiz = null;
    }
    
    public void inserir(int valor){
        raiz = inserir(raiz, valor);
    }
    private No inserir(No atual, int valor){

        if(atual == null) return new No(valor, null, null);
        
        if(valor < atual.valor) atual.esq = inserir(atual.esq, valor);
        else if(valor > atual.valor) atual.dir = inserir(atual.dir, valor);
        
        return atual;
    }
    
    public boolean buscar(int proc){
        return buscar(raiz, proc);
    }
    private boolean buscar(No atual, int proc){
        if(atual == null) return false;

        if(atual.valor == proc) return true;
        else if(proc > atual.valor) return buscar(atual.dir, proc);
        else return buscar(atual.esq, proc);
    }

    public void caminhar(){
        caminhar(raiz);
    }
    private void caminhar(No atual){
        if(atual == null) return;
        
        caminhar(atual.esq);
        System.out.print(atual.valor + " ");
        caminhar(atual.dir);
    }

    public int menor(){
        return menor(raiz);
    }
    private int menor(No atual){
        if(atual.esq == null) return atual.valor;
        else return menor(atual.esq);
    }

    public int maior(){
        return maior(raiz);
    }
    private int maior(No atual){
        if(atual.dir == null) return atual.valor;
        else return maior(atual.dir);
    }

    public int contarNos(){
        return contarNos(raiz);
    }
    private int contarNos(No atual){
        
        if(atual == null) return 0;
        return 1 + contarNos(atual.esq) + contarNos(atual.dir);
    }

    public int altura(){
        return altura(raiz);
    }
    private int altura(No atual){
        if(atual == null) return 0;

        int esq = altura(atual.esq);
        int dir = altura(atual.dir);
        return (esq > dir)? 1 + esq : 1 + dir; 
    }
    
    public static void main(String[] args){

        Arvore arvore = new Arvore();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);
        arvore.inserir(10);
        arvore.inserir(25);
        arvore.inserir(35);
        arvore.inserir(45);
        arvore.inserir(55);
        arvore.inserir(65);
        arvore.inserir(75);
        arvore.inserir(90);

        System.out.println(arvore.menor());
        System.out.print(arvore.maior());
    }
}