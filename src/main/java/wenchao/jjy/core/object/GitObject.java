package wenchao.jjy.core.object;

public interface GitObject {
    String getFORMAT();

    String getHeader();

    byte[] getContent();

    String path();

    String getHash();


}