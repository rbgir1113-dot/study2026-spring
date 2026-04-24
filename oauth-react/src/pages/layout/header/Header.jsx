import React from 'react';
import { Link } from 'react-router-dom';
import S from './style';
import useAuthStore from '../../../store/useAuthStore';

const Header = () => {

  const {isAuthenticated} = useAuthStore()



  return (
    // 숨겨야함
    <>
      {isAuthenticated ? (
          <S.header>
            <S.Link to={"/member/my-page"}>마이페이지</S.Link>
          </S.header>
          ) : (
          <S.header>
            <S.Link to={"/member/join"}>회원가입</S.Link>
            <S.Link to={"/member/login"}>로그인</S.Link>
          </S.header>
    )}
    </>
  );
};

export default Header;