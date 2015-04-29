package com.lb.sample;

import java.io.PrintStream;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class NamedKieSessionExample {
	public void go(PrintStream out) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();

        KieSession kSession = kContainer.newKieSession("ksession_1");
        kSession.setGlobal("out", out);
        kSession.insert(new LbMsg("Dave", "Hello, HAL. Do you read me, HAL?"));
        kSession.fireAllRules();
    }


    public static void main(String[] args) {
    	System.out.println("... NamedKieSessionExample start ...");
        new NamedKieSessionExample().go(System.out);
    }
    
}
