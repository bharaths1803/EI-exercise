//Adapter Pattern

//Use Case: An electric outlet that supports charging devices with different plug types (Type A, Type B).

// Target interface
interface Chargeable {
    void charge();
}

// Adaptee
class TypeAPlug {
    public void connectTypeA() {
        System.out.println("Charging with Type A plug.");
    }
}

// Adapter
class TypeAAdapter implements Chargeable {
    private TypeAPlug plug;

    public TypeAAdapter(TypeAPlug plug) {
        this.plug = plug;
    }

    @Override
    public void charge() {
        plug.connectTypeA();
    }
}

public class StructuralPattern1 {
    public static void main(String[] args) {
        TypeAPlug typeAPlug = new TypeAPlug();
        Chargeable adapter = new TypeAAdapter(typeAPlug);

        adapter.charge();
    }
}