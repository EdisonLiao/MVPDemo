package com.example.edisonliao.mvpdemo.mvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MainModelResponse {

	@SerializedName("error")
	private boolean error;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}