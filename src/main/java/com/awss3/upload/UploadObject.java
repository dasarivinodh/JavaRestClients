package com.awss3.upload;

// Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-s3-developer-guide/blob/master/LICENSE-SAMPLECODE.)

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class UploadObject {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		String bucketName = "testjavaupload25";
		try {
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
					.withCredentials(new ProfileCredentialsProvider()).build();
			TransferManager tm = TransferManagerBuilder.standard().withS3Client(s3Client)
					.withMultipartUploadThreshold((long) (5 * 1024 * 1025)).build();
			String keyName = "Kick_close-up.jpg";
			File file = new File("C://Kick_close-up.jpg");
			ProgressListener progressListener = progressEvent -> System.out
					.println("Transferred bytes: " + progressEvent.getBytesTransferred());
			PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);
			request.setProgressListener(progressListener);
			Upload upload = tm.upload(request);
			upload.waitForCompletion();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}