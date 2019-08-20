package com.awss3.upload;

import java.io.File;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class HighLevelMultipartUpload {

	public static void main(String[] args) throws Exception {

		String bucketName = "testjavaupload25";
		String keyName = "newfolder/test.jpg";
		String filePath = "c:/Kick_close-up.jpg";

		try {
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
					.withCredentials(new ProfileCredentialsProvider()).build();
			TransferManager tm = TransferManagerBuilder.standard().withS3Client(s3Client).build();

			Upload upload = tm.upload(bucketName, keyName, new File(filePath));
			System.out.println("Object upload started");

			upload.waitForCompletion();
			System.out.println("Object upload complete");
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		} catch (SdkClientException e) {
			e.printStackTrace();
		}
	}
}
