public abstract class OutputNode2 extends ActiveNode{
    protected InputPort[] inputPorts;
    protected OutputNode2(int count){
        super();
        this.inputPorts = new InputPort[count];
        for(int i = 0; i<count; i++){
            this.inputPorts[i] = new InputPort(this);
        }
    }
    protected OutputNode2(String name, int count){
        super(name);
        this.inputPorts = new InputPort[count];
        for(int i = 0; i<count; i++){
            this.inputPorts[i] = new InputPort(this);
        }
    }
    //다시 확인하기
    protected OutputNode2(String name){
        super(name);
        this.inputPorts = new InputPort[10];
        for(int i = 0; i<10; i++){
            this.inputPorts[i] = new InputPort(this);
        }
    }

    public OutputNode2() {
        super();
    }


    public int getInputPortCount(){
        return this.inputPorts.length;
    }

    public InputPort getInputPort(int index) {
        if(index < this.inputPorts.length){
            return this.inputPorts[index];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
