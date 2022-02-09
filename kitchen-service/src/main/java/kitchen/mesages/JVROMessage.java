package kitchen.mesages;

public interface JVROMessage {

    default <T> Class<T> getClassType () {
       return this.getClassType();
    }
}
