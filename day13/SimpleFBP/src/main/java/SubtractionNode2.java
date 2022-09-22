import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubtractionNode2 extends InputOutputNode2{
    Message message;
    public SubtractionNode2(){
        super(2,1);
    }
    public SubtractionNode2(int inputCount, int outputCount){
        super(inputCount,outputCount);
    }
    public synchronized void main(){
        List arrays = new ArrayList();
        for(int i = 0; i < this.getInputPortCount(); i++){
            ;
            while(this.getInputPort(i) != null && this.getInputPort(i).hasMessage()){
                arrays.add(this.getInputPort(i).get().getPayload());
                this.getInputPort(i).remove();
            }
        }
        int result = 0;
        for(int i = 1; i < arrays.size(); i++){
            int presub = (Integer)arrays.get(i-1);
            int sub = (Integer)arrays.get(i);
            result = (presub - sub);
        }
        this.message = new Message(result);
        this.getInputPort(0).put(message);
        this.output(this.message);
    }

    public void connectOutput(int index, Wire wire) {
        this.output(this.message);
    }

    public void connectInput(int i, Wire wire) {
        List arrays = new ArrayList();
        while(this.getInputPort(i) != null && this.getInputPort(i).hasMessage()){
            arrays.add(this.getInputPort(i).get().getPayload());
            this.getInputPort(i).remove();
        }
        int result = 0;
        for(i = 1; i < arrays.size(); i++){
            int presub = (Integer)arrays.get(i-1);
            int sub = (Integer)arrays.get(i);
            result = (presub - sub);
        }
        this.message = new Message(result);
        this.getInputPort(0).put(message);
    }
}
