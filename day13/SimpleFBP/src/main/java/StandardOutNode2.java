public class StandardOutNode2 extends OutputNode2{
    private int count;
    public StandardOutNode2(){
        super();

    }
    public StandardOutNode2(int count){
        super(count);
        this.count = count;
    }
    public StandardOutNode2(String name){
        super(name);
    }

    @Override
    public synchronized void main(){
        for(int i = 0; i < count; i++){
            while(this.getInputPort(i) != null && this.getInputPort(i).hasMessage()){
                System.out.println("output : " + this.getInputPort(i).get().getPayload());
                this.getInputPort(i).remove();
            }
        }
    }
    public void connectInput(int i, Wire wire5) {
    }
}
