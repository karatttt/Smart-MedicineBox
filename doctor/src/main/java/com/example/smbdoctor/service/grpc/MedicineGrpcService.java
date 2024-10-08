package com.example.smbdoctor.service.grpc;

import com.example.smbdoctor.entity.MedicationInfo;
import com.example.smbdoctor.mapper.MedicationInfoMapper;

import com.smb.GrpcParams;
import com.smb.SmbServiceGrpc;
import com.smb.SmbServiceProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class MedicineGrpcService extends SmbServiceGrpc.SmbServiceImplBase {

    @Autowired
    MedicationInfoMapper medicationInfoMapper;

    @Override
    public void getMedicineInfo(GrpcParams.MedicineReq request, StreamObserver<GrpcParams.MedicineResponse> responseObserver) {
        System.out.println(("请求中的参数为msg:{},code:{}" + request.getMedicineId()));
        //创建一个响应对象
        MedicationInfo medicationInfo = medicationInfoMapper.selectById(request.getMedicineId());
        GrpcParams.MedicineResponse medicineResponse = GrpcParams.MedicineResponse.newBuilder()
                .setDescription(medicationInfo.getDescription())
                .setType(medicationInfo.getType())
                .setImageurl(medicationInfo.getImageurl())
                .setName(medicationInfo.getName()).build();
        //将该响应对象返回给调用者
        responseObserver.onNext(medicineResponse);
        //这次调用结束了
        responseObserver.onCompleted();
    }
}
