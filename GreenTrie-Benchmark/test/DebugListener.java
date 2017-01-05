/*
 * Copyright (C) 2014, United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 *
 * Symbolic Pathfinder (jpf-symbc) is licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */




import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

import gov.nasa.jpf.jvm.bytecode.JVMInvokeInstruction;
import gov.nasa.jpf.report.PublisherExtension;
import gov.nasa.jpf.symbc.bytecode.BytecodeUtils;
import gov.nasa.jpf.symbc.numeric.PCChoiceGenerator;



public class DebugListener extends PropertyListenerAdapter implements PublisherExtension {

	/* Locals to preserve the value that was held by JPF prior to changing it
	 * in order to turn off state matching during symbolic execution
	 * no longer necessary because we run spf stateless */
	


	public DebugListener(Config conf, JPF jpf) {
		
	}
	
	@Override
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo mi) {
			ThreadInfo ti = currentThread;
			Config conf = vm.getConfig();
		if ((BytecodeUtils.isClassSymbolic(conf, mi.getClassName(), mi, mi.getFullName()))
				|| BytecodeUtils.isMethodSymbolic(conf, mi.getFullName(), mi.getNumberOfArguments(), null)){
			StackFrame fr = ti.getModifiableTopFrame();
			System.out.println("methodEntered:"+mi);
		}
		super.methodEntered(vm, currentThread, mi);
	}

	@Override
	 public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction, Instruction executedInstruction) {

		if (!vm.getSystemState().isIgnored()) {
			Instruction insn = executedInstruction;
			MethodInfo mi=insn.getMethodInfo();
			ThreadInfo ti = currentThread;
			Config conf = vm.getConfig();
			if ((BytecodeUtils.isClassSymbolic(conf, mi.getClassName(), mi, mi.getBaseName()))
					|| BytecodeUtils.isMethodSymbolic(conf, mi.getFullName(), mi.getNumberOfArguments(), null)){
				System.out.println(insn.getInstructionIndex()+":"+insn);
				if (insn instanceof JVMInvokeInstruction) {
					//System.out.println(((JVMInvokeInstruction) insn).getInvokedMethodName());
					//TODO 鍒ゆ柇鏄惁鏄彃瑁呰鍙�
//					PCChoiceGenerator cg = getPCChoiceGenrator(vm);
//					System.out.println("path condition:"+cg.getCurrentPC());
//					vm.getSearch().setIgnoredState(true);
				}
				
				
			}
		}
	}
	
	private PCChoiceGenerator getPCChoiceGenrator(VM vm) {
		PCChoiceGenerator prevPcGen;
		ChoiceGenerator<?> cg = vm.getChoiceGenerator();
		if (cg instanceof PCChoiceGenerator)
			prevPcGen = (PCChoiceGenerator) cg;
		else
			prevPcGen = (PCChoiceGenerator) cg.getPreviousChoiceGeneratorOfType(PCChoiceGenerator.class);
		return prevPcGen;
	}
}
