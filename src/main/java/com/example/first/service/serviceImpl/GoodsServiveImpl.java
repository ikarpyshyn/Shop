package com.example.first.service.serviceImpl;
import com.example.first.dto.*;
import com.example.first.entity.Goods;
import com.example.first.repository.CategoryRepository;
import com.example.first.repository.GoodsRepository;
import com.example.first.repository.SubCategoryRepository;
import com.example.first.service.GoodsService;
import com.example.first.specification.GoodsSpecefication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GoodsServiveImpl implements GoodsService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Override

    public GoodsResponse save(GoodsRequest goodsRequest) throws IOException {
        Goods goods = new Goods();
        goods.setId(goodsRequest.getId());
        goods.setNameGoods(goodsRequest.getNameGoods());
        goods.setPrice(goodsRequest.getPrice());
        goods.setImg(goodsRequest.getImg());
        goods.setSubCategory(subCategoryRepository.findOne(goodsRequest.getIdSubCategory()));

        byte[] fileContent;
        BASE64Decoder decoder = new BASE64Decoder();
        fileContent = decoder.decodeBuffer(goodsRequest.getImg().split(",")[1]);
        String expansion = goodsRequest.getImg().split(",")[0].split("/")[1].split(";")[0];
        String name = UUID.randomUUID().toString();
        MyMultipartFile multipartFile = new MyMultipartFile(fileContent, name, expansion);
        saveFile(multipartFile);
        goods.setImg(name + "." + expansion);
        return new GoodsResponse(goodsRepository.save(goods));
    }

    private void saveFile(MultipartFile file) throws IOException {
        File pathToFolder = new File("C:\\JAVA\\CateClub\\FrontEnd\\projectCateClub\\imgForGoods");
        createFolder(pathToFolder);
        File newFile = new File(pathToFolder + "/" + file.getOriginalFilename());
        writeFile(newFile, file);
    }

    private void createFolder(File path) {
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    private void writeFile(File file, MultipartFile multipartFile) throws IOException {
        try (OutputStream fos = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(multipartFile.getBytes(), 0, multipartFile.getBytes().length);
            bos.flush();
        } catch (IOException e) {

        }
    }

    @Override
    public Goods findOne(Long id) {
        return goodsRepository.findOne(id);
    }

    @Override
    public List<GoodsResponse> findAllBySubCategoryId(Long subCategoryId) {
        return goodsRepository.findAllBySubCategoryId(subCategoryId).stream().map(GoodsResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<GoodsResponse> findAll() {
        List<Goods> goodsList = goodsRepository.findAll();
        return goodsList.stream().map(GoodsResponse::new).collect(Collectors.toList());
    }

    @Override
    public GoodsResponse update(Long id, GoodsRequest goodsRequest) {
        return null;
    }


    @Override
    public void delete(Long id) {
        goodsRepository.delete(id);
    }

    @Override
    public List<Goods> filter(GoodsSpecRequest goodsSpecRequest) {
        GoodsSpecefication goodsSpecefication = new GoodsSpecefication(goodsSpecRequest);
        return goodsRepository.findAll(goodsSpecefication);
    }

    @Override
    public Page<Goods> findAll(MyPageRequest myPageRequest) {

        Sort sort = new Sort(myPageRequest.getSortRequest().getDirection(), myPageRequest.getSortRequest().getSortProp());
        PageRequest pageRequest =
                new PageRequest(myPageRequest.getNumberPage(), myPageRequest.getSizePage(), sort);
        Page<Goods> goodsPage = goodsRepository.findAll(pageRequest);

        return goodsPage;

    }

}