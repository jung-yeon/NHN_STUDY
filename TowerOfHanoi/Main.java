package TowerOfHanoi;

public class Main {
    private static void move(Tower base, Tower target, Tower temp, long count){
//        if(count != 1){
//            move(base, target, temp ,count - 1);
//        }
        //Disk disk = base.pop();
       // target.push(disk);
        //System.out.println("Move " + disk.getSize() + "from tower " + base.getName() + "to tower " + target.getName());
    }
    public void run(Tower base, Tower target, Tower temp){
        move(base,target,temp,base.getCount());
        if(base.getCount() == 1){

            return;
        }
        move(base, target, temp, base.getCount() - 1);
    }
    public static void main(String[] args) {
        Tower TowerA = new Tower("A");
        Tower TowerB = new Tower("B");
        Tower TowerC = new Tower("C");

        TowerA.push(new Disk("5",5));
        TowerA.push(new Disk("4",4));
        TowerA.push(new Disk("3",3));
        TowerA.push(new Disk("2",2));
        TowerA.push(new Disk("1",1));
    }
}
