package org.crowdcomputer.impl.data;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.crowdcomputer.impl.utils.BaseTask;
import org.json.simple.JSONObject;

public class JoinObject extends BaseTask {
	
	private Expression field;

	private Logger log = LogManager.getLogger(this.getClass());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		init(execution);
		String data = getDatas(execution);
//		mergedata and joinobject is the same function. the power of python
		JSONObject result = croco.joinObject(data, field.getExpressionText());
		log.debug("Join object result " + result.get("results"));

		setResult(execution, result);
		
		
	}

}
