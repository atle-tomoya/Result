package jp.gr.java_conf.atle42.library.result;

import org.junit.Test;

import kotlin.Unit;

import static org.junit.Assert.assertEquals;


public class ResultTest {

	@Test
	public void testSuccess() throws Exception {
		Result<String> success = new Result("success");
		success
				.success(it -> {
					System.out.println(it);
					assertEquals("success", it);
				})
				.failure(it -> {
					System.out.println(it.getMessage());
				});
	}

	@Test
	public void testFailure() throws Exception {
		Result<String> failure = new Result(new Error("failure"));
		failure
				.success(it -> {
					System.out.println(it);
				})
				.failure(it -> {
					System.out.println(it.getMessage());
					assertEquals("failure", it.getMessage());
				});
	}
}
