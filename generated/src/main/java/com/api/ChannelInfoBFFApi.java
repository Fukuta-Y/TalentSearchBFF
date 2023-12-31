/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.ChannelInfoList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T16:53:51.944573+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "channelInfoBFF", description = "the channelInfoBFF API")
@RequestMapping("api")
public interface ChannelInfoBFFApi {

    /**
     * GET /channelInfoBFF : チャンネル情報を取得するBFF
     * チャンネル情報を取得するBFF
     *
     * @return チャンネル情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getChannelInfoBFF",
        summary = "チャンネル情報を取得するBFF",
        tags = { "channelInfoBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "チャンネル情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ChannelInfoList.class))
            })
        }
    )
    @GetMapping("/channelInfoBFF")
    ResponseEntity<ChannelInfoList> getChannelInfoBFF(
        
    );

}
