package messaging;

public class JVROMessage {

    private byte [] data;
    private Class<?> clazzType;

    public JVROMessage(){}

    public JVROMessage(byte[] data, Class<?> clazzType) {
        this.data = data;
        this.clazzType = clazzType;
    }

    public byte[] getData() {
        return data;
    }

    public Class<?> getClazzType() {
        return clazzType;
    }
}
