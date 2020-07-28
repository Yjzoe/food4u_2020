package com.remake.food4u.service;

import com.remake.food4u.domain.board.Board;
import com.remake.food4u.domain.board.BoardRepository;
import com.remake.food4u.web.dto.BoardListResponseDto;
import com.remake.food4u.web.dto.BoardResponseDto;
import com.remake.food4u.web.dto.BoardSaveRequestDto;
import com.remake.food4u.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository repo;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {
        return repo.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long no, BoardUpdateRequestDto requestDto) {
        Board board = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        board.update(requestDto.getTitle(), requestDto.getContent(),requestDto.getFname());
        return no;
    }

    public BoardResponseDto findByNo(Long no) {
        Board board = repo.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return new BoardResponseDto(board);
    }

    //타입 출력
    @Transactional
    public Page<BoardListResponseDto> findByTypeOrderByCreateDateDesc(int type, Pageable pageable) {
        return repo.findByTypeOrderByNoDesc(type, pageable).map(BoardListResponseDto::new);
    }

    @Transactional
    public void delete(Long no) {
        Board board = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        repo.delete(board);
    }
}
