package wenchao.jjy.core.object;

public interface GitObjectFactory {
    /**
     * 读取gitObject
     *
     * @param path
     * @return
     */
    GitObject read(String path);

    /**
     * gitObject持久化
     *
     * @param gitObject
     */
    void write(GitObject gitObject);
}
