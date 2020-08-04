package br.com.uol.pagseguro.api;

import org.powermock.core.classloader.annotations.PowerMockIgnore;

//@PowerMockIgnore({"javax.management.", "com.sun.org.apache.xerces.",
//        "javax.xml.", "org.xml.", "org.w3c.dom.",
//        "com.sun.org.apache.xalan.", "javax.activation.*"})
//@PowerMockIgnore({"java.xml.", "javax.xml.", "org.xml.", "javax.activation.*", "com.sun.xml.", "javax.xml.parsers."})

// obscure fix:
// from https://github.com/powermock/powermock/issues/864#issuecomment-410182836
@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*"})
public class BaseTestClassWithPowerMockFix {
}
