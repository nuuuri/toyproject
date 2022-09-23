import { useState } from "react";
import styled from "styled-components";
import moment from "moment";
import Pagination from "components/Pagination";

export default function PostListPage() {
  const [currentPage, setCurrentPage] = useState(1);
  const limit = 20;
  const offset = (currentPage - 1) * limit;

  const dummyPosts: any[] = [
    {
      id: 123,
      title: "test",
      content: "test",
      date: "22.09.23",
      look: 3,
      writer: "nuuuri",
    },
  ];

  return (
    <Container>
      <h1>게시판</h1>

      <PostList>
        <thead>
          <tr>
            <th className="td_number"></th>
            <th className="td_title t_c">제목</th>
            <th className="td_writer">글쓴이</th>
            <th className="td_date">작성일</th>
            <th className="td_look">조회</th>
          </tr>
        </thead>
        <tbody>
          {dummyPosts.slice(offset, offset + limit).map((post: any) => (
            <tr key={post.id}>
              <td className="td_number">{post.id}</td>
              <td className="td_title">{post.title}</td>

              <td className="td_writer">{post.writer}</td>
              <td className="td_date">
                {moment(post.date).format("YY.MM.DD")}
              </td>
              <td className="td_look">{post.look}</td>
            </tr>
          ))}
        </tbody>
      </PostList>

      <Footer>
        <div />
        <Pagination
          totalPage={Math.ceil(dummyPosts.length / limit)}
          currentPage={currentPage}
          setCurrentPage={setCurrentPage}
        />
        <button className="write_button">글쓰기</button>
      </Footer>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
`;
const PostList = styled.table`
  width: 80%;
  margin: 20px 0 20px;
  border-collapse: collapse;
  text-align: center;
  cursor: default;

  thead {
    border-top: 1px solid #bbb;
    border-bottom: 1px solid #e4e4e4;
    color: #333;

    th {
      padding: 7px 10px;
      font-size: 12px;
      font-weight: 500;
    }
  }

  td {
    padding: 9px 0 9px;
    font-size: 13px;
    font-weight: 500;
    line-height: 19px;
    border-bottom: 1px solid #f5f5f5;
    color: #666;
  }

  .td_title {
    text-align: left;
  }
  .td_writer {
    width: 200px;
    padding-left: 0;
    text-align: left;
  }
  .td_date {
    width: 66px;
  }
  .td_number,
  .td_look {
    width: 60px;
  }

  .t_c {
    text-align: center;
  }
`;
const Footer = styled.div`
  display: flex;
  width: 80%;
  justify-content: space-between;

  .write_button {
    border: 1px solid #bbb;
    border-radius: 3px;
    background: #fff;
    cursor: pointer;
  }
`;
