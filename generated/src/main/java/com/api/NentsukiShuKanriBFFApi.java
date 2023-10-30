/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.MNentsukiShuKanri;
import com.model.NentsukiShuKanriBFF;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-22T19:55:15.998116+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "nentsukiShuKanriBFF", description = "the nentsukiShuKanriBFF API")
@RequestMapping("${openapi.bFF.base-path:}")
public interface NentsukiShuKanriBFFApi {

    /**
     * POST /nentsukiShuKanriBFF : 年月週管理マスタ情報を登録または更新するBFF
     * 年月週管理マスタ情報を登録または更新するBFF
     *
     * @param mnentsukiShuKanri 年月週管理マスタ情報を登録または更新するBFF (optional)
     * @return 登録または更新した年月週管理マスタDTOの情報 (status code 200)
     */
    @Operation(
        operationId = "postProgramTorokuKoshinBFF",
        summary = "年月週管理マスタ情報を登録または更新するBFF",
        tags = { "nentsukiShuKanriBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "登録または更新した年月週管理マスタDTOの情報", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = NentsukiShuKanriBFF.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/nentsukiShuKanriBFF",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<List<NentsukiShuKanriBFF>> postProgramTorokuKoshinBFF(
        @Parameter(name = "MNentsukiShuKanri", description = "年月週管理マスタ情報を登録または更新するBFF") @Valid @RequestBody(required = false) MNentsukiShuKanri mnentsukiShuKanri
    );

}